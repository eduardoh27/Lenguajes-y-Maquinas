"""
     
Proyecto 0 de LyM
Ernesto José Duarte Mantilla - Sección 3
Eduardo José Herrera Alba - Sección 3

"""

def init_Variables()->dict:
    variables = {}
    return variables
 
def add_Variable(variables, variable, valor, funciones)-> None:
    funciones.pop(variable, None) #
    variables[variable] = valor

def del_Variable(variables, variable):
    variables.pop(variable, None)

def get_Value(variables, variable):
    return variables[variable]

def exist_Variable(variables, variable):
    return variable in variables

def init_Funciones():
    funciones = {}
    return funciones

def add_Funcion(funciones, funcion, params, variables)-> None:
    variables.pop(funcion, None) #
    funciones[funcion] = params

def del_Funcion(funciones, funcion):
    funciones.pop(funcion, None)

def get_NumberParams(funciones, funcion):
    n = len(funciones[funcion])
    return n

def get_Params(funciones, funcion):
    return funciones[funcion]

def exist_Funcion(funciones, funcion):
    return funcion in funciones



def init_Keywords()->list:
    keywords = ["MOVE", "RIGHT", "LEFT", "ROTATE", "LOOK", "DROP", "FREE", "PICK", "POP", #SENCILLOS
                "CHECK", "BLOCKEDP", "NOP", "BLOCK", "()?" "REPEAT", "() []?", "IF", "[]?" #COMPLEJOS
                "DEFINE", "TO", ":", "OUTPUT", "END"]
    return keywords


def recorrer_Lista(lista, variables, keywords, funciones, 
                    inside_if=False, inside_block=False, inside_func=False):
    correcto = True
    newCommand = True
    stop = False
    
    if inside_block:
        minimo_1Command = False

    i = 0
    while i < len(lista) and correcto and not stop:
        
        if inside_if and lista[i] == "]":
            i -= 1 # como no hice break, habrá un i+=1 al final
            stop = True
        
        elif inside_block and lista[i] == ")":
            i -= 1
            stop = True
            if not minimo_1Command:
                correcto = False
                print("En el block debe haber por lo menos 1 comando")
        
        elif inside_func and lista[i] == "END":
            i -= 1
            stop = True
        
        elif lista[i] == "NEWLINE":
            #if lista[i+1] != "NEWLINE": # ¿"\n" or " "? (or ""?) Lo hice cuando hay varios newlines dentro de un bloque
            #print("NEW",i)
            newCommand = True
               
        elif newCommand == True :
            CommandName = lista[i]
            print("CommandName",lista[i])
            correcto, termina_en = isCommand(CommandName, i, lista, variables, keywords, funciones)
            if inside_block and not minimo_1Command and correcto:
                minimo_1Command = True
                
            i = termina_en
            newCommand = False

        else:
            # lo puse porque no se espera un nuevo comando. Ver "ERROR1" en screenshots
            print("ELSE i="+str(i))
            correcto = False
        
        print("correcto",correcto)

        i+=1

    return correcto, i

def isCommand(CommandName, i, lista, variables, keywords, funciones):
    "Verifica que si comando es correcto y regresa en qué parte de la lista termina"

    correcto = False
    termina_en = i

    tipo1 = ["MOVE", "RIGHT", "LEFT", "ROTATE", "DROP", "FREE", "PICK", "POP"]
    if CommandName in tipo1:
        print("T1. lista[i="+str(i)+"] " +lista[i])
        # puede faltar ignore_NEWLINE
        if is_Type(variables, lista[i+1], "numero"):
            termina_en = i+1
            correcto = True

    elif CommandName == "LOOK":
        print("T2. lista[i="+str(i)+"] " +lista[i])
        if is_Type(variables, lista[i+1], "direccion"):
            termina_en = i+1
            correcto = True

    elif CommandName == "CHECK":
        print("T3. lista[i="+str(i)+"] " +lista[i])
        if is_Type(variables, lista[i+1], "opcion"):
            if is_Type(variables, lista[i+2], "numero"):
                termina_en = i+2
                correcto = True

    elif CommandName == "BLOCKEDP" or CommandName == "NOP":
        # OJO CON ESTOS
        print("T4. lista[i="+str(i)+"] " +lista[i])
        termina_en = i
        correcto = True
    
    elif CommandName == "DEFINE":
        print("T5. lista[i="+str(i)+"] " +lista[i])
        if lista[i+1].islower(): # ¿ and .isalpha()?
            if is_Type(variables, lista[i+2], "numero"):
                add_Variable(variables, lista[i+1], lista[i+2], funciones)
                termina_en = i+2
                correcto = True
            else:
                print("Debe ingresar un número entero como valor de la variable")
        else:
            print("El nombre de la variable debe ser un string en minúsculas")

    elif CommandName == "IF":
        print("T6. lista[i="+str(i)+"] " +lista[i])
        if lista[i+1] == "BLOCKEDP" or lista[i+2] == "!BLOCKEDP":
            # ¿SOLO EXISTEN ES0S D0S B0OL EXPR?
            # ¿Se permiten Newlines?
            
            if lista[i+2] == "[":
                correcto, j = recorrer_Lista(lista[i+3:], variables, keywords, funciones, inside_if=True)
                termina_en = i+3+j
        else:
            print("La expresión del IF debe ser booleana")  

    elif CommandName == "(":
        # ¿Podría haber newlines?
        print("T7. lista[i="+str(i)+"] " +lista[i])

        if lista[i+1] == "BLOCK":
            correcto, j = recorrer_Lista(lista[i+2:], variables, keywords, funciones, inside_block=True)
            termina_en = i+2+j
            #print("termina_en dentro del BLOCK: ",termina_en, "lista[termina_en]: ",lista[termina_en])
        
        elif lista[i+1] == "REPEAT":
            if is_Type(variables, lista[i+2], "numero"):
                # ¿Podría haber newlines?
                if lista[i+3] == "[":
                    # ¿Podría haber newlines?
                    correcto, j = recorrer_Lista(lista[i+4:], variables, keywords, funciones, inside_if=True)
                    i += 4+j
                    if correcto:
                        i, correcto = ignore_Newlines(i+1, lista)
                        if lista[i] == ")" and correcto:
                            termina_en = i
                            #print("termina_en dentro del repeat: ",termina_en, "lista[termina_en]: ",lista[termina_en])
#{funcion1: [:a, :b, :z], funcion2: [], ...}
    elif CommandName == "TO":
        print("T8. lista[i="+str(i)+"] " +lista[i])
        if lista[i+1] not in keywords: # ¿Será? (nombre de funcion)
            j = 2
            parametros = []
            while ":" == lista[i+j][0]:  # acepta 0 parámetros
                parametros.append(lista[i+j])
                add_Variable(variables, lista[i+j], None, funciones)
                j += 1
            add_Funcion(funciones, lista[i+1], parametros, variables)
            # debo añadir la funcion y los parametros a la lista porque 
            # necesito los parametros al usarlos en el bloque de comandos 
            # dentro del cuerpo la función
            #newline
            i, correcto = ignore_Newlines(i+j, lista)
            if lista[i] == "OUTPUT" or lista[i] == "output":
                correcto, k = recorrer_Lista(lista[i+1:], variables, keywords, funciones, inside_func=True)
                if correcto:
                    termina_en = i+1+k
                    correcto = True
                else: # creo que a fin de cuentas da igual. Al fin y al cabo el programa solo dirá "INCORRECTO"
                    for variable in parametros:
                        del_Variable(variables, variable)
                        del_Funcion(funciones, lista[i+1])
            else: # creo que a fin de cuentas da igual. Al fin y al cabo el programa solo dirá "INCORRECTO"
                for variable in parametros:
                    del_Variable(variables, variable)
                    del_Funcion(funciones, lista[i+1])

    else:
        if CommandName in funciones:
            n = get_NumberParams(funciones, CommandName)

            params_validos = True
            if i+n <= len(lista)-1: # si no se sale de la lista
                for j in range(1, n+1):
                    if not is_Type(variables, lista[i+j], "numero"):
                        params_validos = False
            else: # si se sale de la lista no alcanza a recibir los parametros
                params_validos = False

            if params_validos:
                correcto = True
                termina_en = i+n
        # buscar las funciones.
        pass
            
    return correcto, termina_en


def is_Type(variables, string, tipo):
    es_tipo = False
    if tipo == "numero":
        if string.isdigit() or (exist_Variable(variables,string) and (get_Value(variables,string) == None or get_Value(variables,string).isdigit())):
            es_tipo = True
    
    elif tipo == "direccion":
        direcciones = ["N", "S", "W", "E"]
        if string in direcciones or (exist_Variable(variables,string) and (get_Value(variables,string) in direcciones or get_Value(variables,string) == None)):
            es_tipo = True
    
    elif tipo == "opcion":
        opciones = ["C", "B"]
        if string in opciones or (exist_Variable(variables,string) and (get_Value(variables,string) in opciones or get_Value(variables,string) == None)):
            es_tipo = True

    #elif tipo == "variable":
        
    return es_tipo


# [ "]", NL, ")"]

# [ "a" - 0 , r - 1 , b -2 , NL - 3] len = 4 
# i = 1
# i = 2
# i = 3
# [ "]", ")", Y, 6]

def ignore_Newlines(i, lista):
    """
    i: posición desde la cual debe empezar a ignorar los newlines (primer newline)
    retorna: posición del último newline
    """
    correcto = True
    if lista[i] == "NEWLINE":
        while lista[i+1] == "NEWLINE":
            i+=1
            if i == len(lista)-1:
                correcto = False
                break
        i += 1          

    return i, correcto

"""
def hay_Newline(i, lista):
    hay = False
    termina = ignore_Spaces_Newlines(i, lista)
    if "NEWLINE" in lista[i: termina+1]:
        hay = True
    return hay, termina

#lista= [0, " ", " ", " ", 4, 5]
#print(hay_Newline(1, lista))
"""



def lector_textfile(nombre_archivo: str):
    archivo = open(nombre_archivo, "r")
    
    lista = []
    lineas = []
    linea = archivo.readline()
    #print(type(linea))
    lineas.append((list(linea)))
    palabras = linea.split(" ")

    lista += palabras

    while len(linea)>0:
        linea = archivo.readline()
        palabras = linea.split(" ")
        lista += palabras
        lineas.append((list(linea)))

    archivo.close()
    return lista

def lexer(nombre_archivo):
    
    archivo = open(nombre_archivo, "r")
    linea = archivo.readline()

    palabras = []
    palabra = ""

    while len(linea)>0:
        for caracter in linea:

            if caracter == " " or caracter == "\t":
                add_Palabra(palabra, palabras)
                #palabras.append(" ")
                palabra = ""
            
            elif caracter == "(":                 
                add_Palabra(palabra, palabras)
                palabras.append("(")
                palabra = ""

            elif caracter == ")":                 
                add_Palabra(palabra, palabras)
                palabras.append(")")
                palabra = ""

            elif caracter == "[":                 
                add_Palabra(palabra, palabras)
                palabras.append("[")
                palabra = ""

            elif caracter == "]":                 
                add_Palabra(palabra, palabras)
                palabras.append("]")
                palabra = ""

            elif caracter == "\n":                 
                add_Palabra(palabra, palabras)
                palabras.append("NEWLINE")
                palabra = ""

            else:
                palabra += caracter

        linea = archivo.readline()

    add_Palabra(palabra, palabras)

    archivo.close()

    return palabras


def add_Palabra(palabra, palabras):
    if palabra != "":
        palabras.append(palabra)
        


def iniciar_Programa():

    variables = init_Variables()
    keywords = init_Keywords()
    funciones = init_Funciones()
    #funciones = {"foo": [2,1], "print": []}
    
    #lista = lector_textfile("ejemplo.txt")
    #print(lista)
    
    #lista = lexer("ejemplo.txt")
    nombre_archivo = input("Introduzca el nombre exacto del textfile: ")
    if ".txt" != nombre_archivo[-4:]:
        nombre_archivo += ".txt"
    nombre_archivo = "ejemplo.txt"
    lista = lexer(nombre_archivo)
    print(lista)

    resultado, _ = recorrer_Lista(lista, variables, keywords, funciones)
    if resultado:
        print("The syntax is CORRECT.")
    else:
        print("The syntax is INCORRECT.")

    print("variables: ",variables)
    
iniciar_Programa()

"""
Dudas:

1. Ignorar newlines y spaces. RTA: ignorar espacios y tabs, pero no newlines
2. split() RTA: Sí se puede usar.
3. ¿Qué otras expresiones booleanas pueden haber además de BLOCKEDP y !BLOCKEDP?
4. ¿Una expresión es necesariamente un bool?
5. No existe indentación? Puede empezarse un command con indentación de 2, por ejemplo?
6. ¿Al fin sí se deben separar los commands por newlines como dice el pdf? RTA: sí
7. ¿Una variable se puede llamar "carro1" o "1carro" o debe ser "carro"? (solo letras+)
8. ¿Qué pasa si una función se llama igual a una variable?


1. El comando no termina con \n necesariamente (ver ejemplo.txt línea 4, 8, 26)
PROBLEMAS:
algunas palabras se guardan con los símbolos = () [] eg. goEnd)
¡EPD, ESPACIOS POR DOQUIER!

[{type: "int", value: "34"}, ,{type: "keyword", value: "BLOCK"}, , ]


importante: los commands terminan antes del \n, los \n se deben interpretar "entre commands"
el IF funciona sin commands, es decir "IF foo []" es correcta


FALTA = 
1. TO foo...
2. foo por fuera! (ver linea 20 de ejemplo.txt). Este foo debe tener los mismos param con los que define la función
3. guardar las funciones
4. Tener en cuenta los tabs \t
5. que los comandos siempre se separan por \n
falta colocar ignore NEWLINES por doquier. por ejemplo. ahi falla por los \n entre simbolos globales(mas no en los comandos):


(REPEAT 3

[
    command 1
    command2
]

)

Ver inicio clase 31/08 Cardozo!!!
"""
