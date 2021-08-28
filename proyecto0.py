"""
       
Proyecto 0 de LyM
Ernesto José Duarte Mantilla - Sección 3
Eduardo José Herrera Alba - Sección 3

"""

def init_Variables()->dict:
    variables = {}
    return variables
 
def add_Variable(variables, variable, valor)-> bool:
    variables[variable] = valor

def get_Value(variables, variable):
    return variables[variable]

def exist_Variable(variables, variable):
    return variable in variables

def init_Keywords()->list:
    keywords = ["MOVE", "RIGHT", "LEFT", "ROTATE", "LOOK", "DROP", "FREE", "PICK", "POP", #SENCILLOS
                "CHECK", "BLOCKEDP", "NOP", "BLOCK", "()?" "REPEAT", "() []?", "IF", "[]?" #COMPLEJOS
                "DEFINE", "TO", ":", "OUTPUT", "END"]
    return keywords



def recorrer_Lista_inicial(lista, variables, dentro_de_if=False):
    correcto = True
    newCommand = True
    i = 0
    while i < len(lista) and correcto:


        if newCommand == True :
            CommandName = lista[i]
            correcto, termina_en = isCommand(CommandName, i, lista, variables) 
            i = termina_en
            newCommand = False

        elif lista[i] == " ":
            i = ignore_Spaces(i, lista)

        elif lista[i] == "NEWLINE":
            if lista[i+1] != "NEWLINE": # ¿"\n" or " "? (or ""?)
                print(i)
                newCommand = True   

        else:
            # lo puse porque no se espera un nuevo comando. Ver "ERROR1" en screenshots
            print("ELSE i="+str(i))
            correcto = False

        i+=1
    return correcto
    
def recorrer_Lista(lista, variables, keywords, inside_if=False, inside_block=False):
    correcto = True
    newCommand = True
    stop = False
    i = 0
    while i < len(lista) and correcto and not stop:
        
        if inside_if and lista[i] == "]":
            i -= 1 # como no hice break, habrá un i+=1 al final
            stop = True
        
        elif inside_block and lista[i] == ")":
            i -= 1
            stop = True
        
        elif lista[i] == "NEWLINE":
            #if lista[i+1] != "NEWLINE": # ¿"\n" or " "? (or ""?) Lo hice cuando hay varios newlines dentro de un bloque
            #print("NEW",i)
            newCommand = True   

        elif newCommand == True :
            CommandName = lista[i]
            correcto, termina_en = isCommand(CommandName, i, lista, variables, keywords) 
            i = termina_en
            newCommand = False

        else:
            # lo puse porque no se espera un nuevo comando. Ver "ERROR1" en screenshots
            print("ELSE i="+str(i))
            correcto = False

        i+=1
    return correcto, i

def isCommand(CommandName, i, lista, variables, keywords):
    "Verifica que si comando es correcto y regresa en qué parte de la lista termina"

    correcto = False
    termina_en = i
    tipo1 = ["MOVE", "RIGHT", "LEFT", "ROTATE", "DROP", "FREE", "PICK", "POP"]
    #if CommandName == "MOVE" or "RIGHT" or "LEFT" or "ROTATE" or "DROP" or "FREE" or "PICK" or "POP": 
        # "LOOK" entró a CommandName, entonces decidí quitarlo

    if CommandName in tipo1:
        print("T1. lista[i="+str(i)+"] " +lista[i])
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
                add_Variable(variables, lista[i+1], lista[i+2])
                termina_en = i+2
                correcto = True

    elif CommandName == "IF":
        print("T6. lista[i="+str(i)+"] " +lista[i])
        if lista[i+1] == "BLOCKEDP" or lista[i+2] == "!BLOCKEDP":
            if lista[i+2] == "[":
                correcto, j = recorrer_Lista(lista[i+3:], variables, keywords, inside_if=True)
                termina_en = i+3+j
                #print("termina_en dentro del if: ",termina_en, "lista[termina_en]: ",lista[termina_en])
        else:
            print("La expresión del IF debe ser booleana.")
    
    elif CommandName == "(":
        print("T7. lista[i="+str(i)+"] " +lista[i])

        if lista[i+1] == "BLOCK":
            correcto, j = recorrer_Lista(lista[i+2:], variables, keywords, inside_block=True)
            termina_en = i+2+j
            #print("termina_en dentro del BLOCK: ",termina_en, "lista[termina_en]: ",lista[termina_en])
        
        elif lista[i+1] == "REPEAT":
            if is_Type(variables, lista[i+2], "numero"):
                if lista[i+3] == "[":
                    correcto, j = recorrer_Lista(lista[i+4:], variables, keywords, inside_if=True)
                    i += 4+j
                    if correcto:
                        i = ignore_Newlines(i+1, lista)
                        if lista[i+1] == ")":
                            correcto = True
                            termina_en = i+1
                            #print("termina_en dentro del repeat: ",termina_en, "lista[termina_en]: ",lista[termina_en])

    elif CommandName == "TO":
        print("T8. lista[i="+str(i)+"] " +lista[i])

        if lista[i+1] not in keywords: # ¿Será?
            pass
            
    return correcto, termina_en


def is_Type(variables, string, tipo):
    es_tipo = False
    if tipo == "numero":
        if string.isdigit() or (exist_Variable(variables,string) and get_Value(variables,string).isdigit()):
            es_tipo = True
    
    elif tipo == "direccion":
        direcciones = ["N", "S", "W", "E"]
        if string in direcciones or (exist_Variable(variables,string) and get_Value(variables,string) in direcciones):
            es_tipo = True
    
    elif tipo == "opcion":
        opciones = ["C", "B"]
        if string in opciones or (exist_Variable(variables,string) and get_Value(variables,string) in opciones):
            es_tipo = True

    #elif tipo == "variable":
        
    return es_tipo



    while lista[i+1] == " " or lista[i+1] == "NEWLINE":
        i+=1
    return i+1


def ignore_Newlines(i, lista):

    if lista[i] == "NEWLINE":
        while lista[i+1] == "NEWLINE":
            i+=1         
        # SE PUEDE SALIR DEL RANGO            
    else:
        i -=1

    return i

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
    print("variables",variables)

    keywords = init_Keywords()
    
    #lista = lector_textfile("ejemplo.txt")
    #print(lista)
    
    #lista = lexer("ejemplo.txt")
    lista = lexer("ejemplo copy.txt")
    print(lista)

    resultado = recorrer_Lista(lista, variables, keywords)[0]
    if resultado:
        print("The syntax is CORRECT.")
    else:
        print("The syntax is INCORRECT.")

    print("variables: ",variables)
    
iniciar_Programa()


"""
Dudas:

1. Ignorar new lines y spaces
2. split() Sí se puede usar.
3. ¿Qué otras expresiones booleanas pueden haber además de BLOCKEDP y !BLOCKEDP?
4. ¿Una expresión es necesariamente un bool?
5. No existe indexación? Puede empezarse un command con indentación de 2, por ejemplo?
6. ¿Al fin sí se deben separar los commands por newlines como dice el pdf?


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
"""