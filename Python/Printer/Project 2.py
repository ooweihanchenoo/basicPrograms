from Queue import Queue
import random

class Printer:
    def __init__(self, ppm):
        self.pagerate = ppm
        self.currentTask = None
        self.timeRemaining = 0
    def tick(self):
        if self.currentTask != None:
            self.timeRemaining = self.timeRemaining - 1
            if self.timeRemaining <= 0:
                self.currentTask = None
    def getPageRate(self):
        return self.pagerate   
    def busy(self):
        if self.currentTask != None:
            return True
        else:
            return False
    def startNext(self,newtask):
        self.currentTask = newtask
        self.timeRemaining = newtask.getPages() * 60/self.pagerate

class Task: 
    def __init__(self,time,min,max):
        self.timestamp = time
        self.pages = random.randrange(min, max)
    def getStamp(self):
        return self.timestamp
    def getPages(self):
        return self.pages
    def waitTime(self, currenttime):
        return currenttime - self.timestamp

def simulation(numSeconds, ppm1, ppm2,minTask,maxTask):
    p1 = Printer(ppm1)
    p2 = Printer(ppm2)    
    pQueue = Queue()
    wTimes = []
    avgList = []

    for currentSecond in range(numSeconds):
        if newpTask():
            task = Task(currentSecond,minTask,maxTask)
            pQueue.enqueue(task)
        if (p1.getPageRate() >= p2.getPageRate() or p2.getPageRate() is 0):
            p1fastest = True
        else:
            p1fastest = False           
        if (not p1.busy() and not p2.busy() and p2.getPageRate() is not 0 and not pQueue.is_empty()):
            if (p1fastest):
                nexttask = pQueue.dequeue()
                wTimes.append(nexttask.waitTime(currentSecond))
                p1.startNext(nexttask)
            elif (not pr1fastest):
                nexttask = pQueue.dequeue()
                wTimes.append(nexttask.waitTime(currentSecond))
                p2.startNext(nexttask)                   
        if (not p1.busy()):
            if (not pQueue.is_empty()):
                nexttask = pQueue.dequeue()
                wTimes.append(nexttask.waitTime(currentSecond))
                p1.startNext(nexttask)
        if (p2.getPageRate() is not 0 and not pr2.busy()):        
            if (not pQueue.is_empty()):
                nexttask = pQueue.dequeue()
                wTimes.append(nexttask.waitTime(currentSecond))
                p2.startNext(nexttask)
            
        p1.tick()
        p2.tick()
        
    avgWait = sum(wTimes)/len(wTimes)
    print("Average Wait %6.2f secs %3d tasks remaining." \
          %(avgWait,pQueue.size()))
    output = ("Average Wait %6.2f secs %3d tasks remaining." \
                   %(avgWait,pQueue.size()))  
    return(avgWait)

def newpTask():
    num = random.randrange(1,181)
    if num == 180:
        return True
    else:
        return False

def main():
    try:                 
        config = open("sim_config.txt", "r")
        stringFin = config.read().split("\n")                 
        cfgList = []
        pSetup = []
        
        for line in stringFin:
            if line is not "":
                cfgList.append(line)
        
        for e in cfgList:
            pSetup.append(int(e))

        durSim = pSetup[0]
        numExperiments = pSetup[1]
        minTaskSize = pSetup[2]
        maxTaskSize = pSetup[3]
        numPrinters = pSetup[4]
        prp1 = pSetup[5]
        
        if (durSim < 3600 or durSim > 36000):
            return IndexError
        if ((minTaskSize < 1 or minTaskSize > 100) or (maxTaskSize < 1 or maxTaskSize > 100 )):
            return ProcessLookupError
        if (prp1 < 1 or prp1 > 50):
            return MemoryError       
        if (numExperiments < 1 or numExperiments > 100):
            return AttributeError     
        elif numPrinters > 2 or numPrinters < 1:
            return SystemExit      
        else:
            prp2 = 0
        if(numPrinters is 2 and (prp2 < 1 or prp2 > 50)):
            return MemoryError     

        experiments = []
        
        for i in range(numExperiments):
            average = simulation(durSim, prp1, prp2,minTaskSize, maxTaskSize)
            experiments.append(average)
            
    except IndexError:
        print("Simulation number is too small or too big, please check again. Exiting.")
    except ProcessLookupError:
        print("Task size number is too small or too big, please check again. Exiting.") 
    except MemoryError:
        print("Paper rate number is too small or too big, Please check again. Exiting.")
    except AttributeError:
        print("Experiment number is too small or too big, please check again. Exiting.")  
    except SystemExit:
        print("Printer number is too small or too big, please check again. Exiting.")                    
if __name__ == "__main__":
    main()