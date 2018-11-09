def sSort(a_list):
    for fill_slot in range(len(a_list) -1, 0, -1):
        pos_of_max = 0
        for location in range(1, fill_slot+1):
            if a_list[location] > a_list[pos_of_max]:
                pos_of_max = location
        temp = a_list[fill_slot] 
        a_list[fill_slot] = a_list[pos_of_max]
        a_list[pos_of_max] = temp
    return a_list

def bSort(a_list):
    for pass_num in range(len(a_list) -1, 0, -1):
        for i in range(pass_num):
            if a_list[i] > a_list[i+1]:
                temp = a_list[i]
                a_list[i] = a_list[i+1]
                a_list[i+1] = temp
    return a_list
    
def mSort(a_list):
    if len(a_list)>1:
        mid = len(a_list)//2
        lefthalf = a_list[:mid]
        righthalf = a_list[mid:]
        mSort(lefthalf)
        mSort(righthalf)
        i=0
        j=0
        k=0
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i] < righthalf[j]:
                a_list[k]=lefthalf[i]
                i=i+1
            else:
                a_list[k]=righthalf[j]
                j=j+1
            k=k+1
        while i < len(lefthalf):
            a_list[k]=lefthalf[i]
            i=i+1
            k=k+1
        while j < len(righthalf):
            a_list[k]=righthalf[j]
            j=j+1
            k=k+1
    return a_list

class BinaryTree:
    def __init__(self, root):
        self.key = root
        self.left_child = None
        self.right_child = None
    def insert(self, new_node):
        if self.left_child == None:
            self.left_child = BinaryTree(new_node)
        else:
            t = BinaryTree(new_node)
            t.left_child = self.left_child
            self.left_child = t
        if self.right_child == None:
            self.right_child = BinaryTree(new_node)
        else:
            t = BinaryTree(new_node)
            t.right_child = self.right_child
            self.right_child = t
    def get_right_child(self):
        return self.right_child
    def get_left_child(self):
        return self.left_child    
    def set_root_val(self, obj):
        self.key = obj         
    def get_root_val(self):
        return self.key

def inorder(tree):
    if tree:
        inorder(tree.get_left_child())
        inorder(tree.get_right_child())
    

def main():
    import time
    import random
    import math
    
    lsize = 0
    sTime = 0
    eTime = 0
    exTime = 0
    
    lsize = int(input("Input List Size: "))
    rlist = []*lsize
    for i in range(lsize):
        rlist.append(random.random()*10.0)
        
    # *** SELECTION SORT ***
    print("\nSELECTION SORT")
    sTime = time.time()
    sSort(rlist)
    eTime = time.time()
    exTime = eTime - sTime
    print("Selection Sort's Execution Time is %.2f Seconds." %(exTime))
    
    # *** BUBBLE SORT ***
    print("\nBUBBLE SORT")
    sTime = time.time()
    sSort(rlist)
    eTime = time.time()
    exTime = eTime - sTime
    print("Bubble Sort's Execution Time is %.2f Seconds." %(exTime))    
   
    # *** MERGE SORT ***
    print("\nMERGE SORT")
    sTime = time.time()
    mSort(rlist)
    eTime = time.time()
    exTime = eTime - sTime
    print("Merge Sort's Execution Time is %.2f Seconds." %(exTime))    
    
    # *** TREE SORT ***
    print("\nTREE SORT")
    sTime = time.time()
    for j in range(len(rlist)):
        tSort = BinaryTree(j)
        tSort.insert(rlist[j])
        inorder(tSort)
    eTime = time.time()
    exTime = eTime - sTime
    print("Tree Sort's Execution Time is %.2f Seconds." %(exTime))       
    
    
if __name__ == "__main__":
    main()