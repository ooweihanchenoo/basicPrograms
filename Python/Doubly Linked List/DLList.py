from DLNode import DLNode
from random import randrange

class DLList:
    def __init__(self):
        self.head = None
        self.tail = None
        
    def is_empty(self):
        return self.head == None and self.tail == None
    
    def add(self, item):
        temp = DLNode(item)
        temp.set_next(self.head)
        if self.head != None:
            self.head.set_previous(temp)
        self.head = temp
        if self.tail == None:
            self.tail = temp
        if self.tail != self.head and self.size() == 2:
            self.tail.set_previous(self.head)

    def append(self, item):
        temp = DLNode(item)
        current = self.head
        for x in range(self.size()):
            if current.get_next() != None:
                current = current.get_next()
        temp.set_previous(current)
        self.tail = temp
        if current != None:
            current.set_next(self.tail)
        else:
            #the tail is the head in a list of 1
            self.head = self.tail

    def size(self):
        current = self.head
        count = 0
        while current != None:
            count = count + 1
            current = current.get_next()
        return count
    
    def contains(self,item):
        current = self.head
        found = False
        while current != None and not found:
            if current.get_data() == item:
                found = True
            else:
                current = current.get_next()
        return found
    
    def remove(self, item):
        if not self.contains(item):
            print("Remove: List does not contain " + item)
            return "Remove: List does not contain " + item
        while self.contains(item):
            current = self.head
            previous = None
            found = False
            while not found:
                if current.get_data() == item:
                    found = True
                else:
                    previous = current
                    current = current.get_next()          
            if previous == None:
                self.head = current.get_next()
            elif previous.get_next().get_next() == None:
                self.tail = previous
            else:
                previous.set_next(current.get_next())
                previous.get_next().set_previous(previous)
            self.tail.set_next(None)

    def printl(self):
        print_list = []
        current = self.tail
        if (not self.is_empty()):
            for x in range(self.size()):
                print_list.append(current.get_data())
                current = current.get_previous()            
        print(print_list)
        
    def slice(self, i, j):
        random_variable = ""
        try:
            i / 2
            j / 2
            if i < 0 or j > self.size() or j < 0 or i > self.size():
                random_variable / 2
        except TypeError:
            print("Slice: Wrong Input")
            return "Slice: Wrong Input"
        if i < j:
            current = self.head
            y = j - 1
            print_list = []
            for x in range(self.size()):
                current = current.get_next()
                if x + 1 == i:
                    while y != 0:
                        print_list.append(current.get_data())
                        current = current.get_next()
                        y -= 1
                    return print_list
        if j < i:
            current = self.head
            y = i - 1
            print_list = []
            for x in range(self.size()):
                current = current.get_next()
                if x + 1 == j:
                    while y != 0:
                        print_list.append(current.get_data())
                        current = current.get_next()
                        y -= 1
                    return print_list

    def swap(self, i, j):
        current = self.head     
        try:
            i / 2
            j / 2
            if i == j or i < 0 or j > self.size()-1 or j < 0 or i > self.size()-1:
                return
        except TypeError:
            return
        
        if i < j:
            for x in range(self.size()):
                previous = current
                current = current.get_next()
                if x + 1 == i:
                    pos_1 = current
                    prev_1 = previous
                    self.remove(current.get_data())   
                if x + 1 == j:
                    pos_2 = current
                    pos_end = current.get_next()
                    prev_2 = previous
                    self.remove(current.get_data())
        if j < i:
            for x in range(self.size()):
                previous = current
                current = current.get_next()
                if x + 1 == j:
                    pos_1 = current
                    prev_1 = previous
                    self.remove(current.get_data())    
                if x + 1 == i:
                    pos_2 = current
                    pos_end = current.get_next()
                    prev_2 = previous
                    self.remove(current.get_data())

        if i == j + 1 or j == i + 1:
            pos_end.set_previous(pos_1)
            pos_1.set_next(pos_end)
            pos_1.set_previous(pos_2)
            pos_2.set_next(pos_1)
            pos_2.set_previous(prev_1)
            prev_1.set_next(pos_2)
        else:
            pos_2.set_next(prev_1.get_next())
            pos_2.set_previous(prev_1)
            prev_1.set_next(pos_2)
            prev_1 = None
    
            pos_1.set_next(prev_2.get_next())
            pos_1.set_previous(prev_2)
            prev_2.set_next(pos_1)

            pos_end.set_previous(pos_1)
            pos_2.get_next().set_previous(pos_2)
            
    def shuffle(self):
        for x in range(self.size()):
            pos_1 = randrange(1,self.size()-1)
            pos_2 = randrange(1,self.size()-1)
                
            self.swap(pos_1,pos_2)

def main():
    hello = "123"
    print_test = DLList()
    print_test.add("Item 3")
    print_test.append("Item 2")
    print_test.add("Item 4")
    print_test.add("Item 6")
    print_test.append("Item 7")
    print_test.add("Item 8")
    
    print_test.printl()


if __name__ == "__main__":
    main()
