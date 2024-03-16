import os 
import shutil
import re

domain = "domain"
model = "model"



def main() :
    res = sth()
    if not "model" in  os.listdir():
        os.mkdir("model")
    os.chdir("model")
    for el in res :
        with open(el , "w") as f :
            f.write(res[el])
        
def sth():
    resMap = dict()
    os.chdir(domain)
    dirFiles = os.listdir()
    for filename in dirFiles :
        fileStr = handleFile(filename)
        fp = filename.split(".")
        nFname = fp[0]+"DTO.java"
        resMap[nFname] = fileStr
        
    os.chdir("..")    
    return resMap


def getListOfClasses() :
    l = os.listdir()
    res = list()
    for f in l :
        res.append(f.split(".")[0]+" ")

    return res

def joinLines(list):
    res = ""
    for l in list:
        res+= l +"\n"
    return res

def handleFile(filename):

    with open(filename ,"r") as f:
        lines = list()
        for line in f:
            lineHandler(line,lines)
        return joinLines(lines)
        


def lineHandler(line, list ):
    if line.strip().startswith("package"):
        list.append(handlePackage(line))
    elif line.startswith("import"):
        res = handleImport(line) 
        if res != "":
            list.append(res)
    elif line.strip().startswith("@"):
        if line.strip().startswith("@Data"):
            list.append(line)
        else:
            ""
    else:
        if line.strip() != "":
            line = handleLine(line)
            list.append(line)





def handleLine(line) :
    classList = getListOfClasses()
    for c in classList :
        reg = ".*\s+" + c.strip() +"\s+.*"

        res = re.match(reg , line)

        if res != None :
            line = re.sub("\s+" + c.strip() +"\s+" , " " +c.strip() +"DTO " , line )
            return line
    return line


def handleImport(line):
    
    substrings = ("jakarta.persistence", "org.springframework.data.annotation" )
    for substring in substrings:
        if substring in line:
            return ""
    return line


def modelDirExists():
    domainDirContnet = os.listdir(path)
    for filename in domainDirContnet:
        handleFile(filename)
        
def lineContains(line , list):
    for el in list:
        res = line.find(el)
        if res != -1 :
            return res
    return -1

def handlePackage(line):
        parts = line.split(".")
        parts[-1] = model
        new_line = ".".join(parts)
        return new_line

main()

