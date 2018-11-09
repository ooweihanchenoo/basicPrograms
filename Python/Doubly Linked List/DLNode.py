class DLNode:
    def __init__(self, init_data):
        self.data = init_data
        self.next = None
        self.previous = None
        
    def get_data(self):
        return self.data
    
    def get_next(self):
        return self.next
    
    def get_previous(self):
        return self.previous
    
    def set_data(self, new_data):
            self.data = new_data
            
    def set_next(self, new_next):
            self.next = new_next

    def set_previous(self, new_previous):
            self.previous = new_previous
