"""
       
Proyecto 0 de LyM
Ernesto José Duarte Mantilla - Sección 3
Eduardo José Herrera Alba - Sección 3

"""


def init_Variables()->dict:
    variables = {}
    return variables
 
def add_Variable(variables, variable, valor)-> None:
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

def iniciar_Programa():
    variables = init_Variables()
    keywords = init_Keywords()
    add_Variable(variables, "n", 12)
    print(exist_Variable(variables, "n"))
    
    #lector_textfile("ejemplo.txt")


def lector_textfile(nombre_archivo: str):
    archivo = open(nombre_archivo, "r")

    lista = []

    linea = archivo.readline()
    lista_p = linea.split(" ")
    lista += lista_p

    while len(linea)>0:
        print(linea)
        linea = archivo.readline()
        lista_p = linea.split(" ")
        lista += lista_p


    print(lista)
    print(len(lista))
    archivo.close()

    
iniciar_Programa()



"""
Dudas:
1. Ignorar new lines y spaces
2. split()
"""