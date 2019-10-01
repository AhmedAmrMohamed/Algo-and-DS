from node import Node 
class Bst:
    def __init__(self,root = Node()):
        self.root = root

    def __len__(self):
        if self.empty():
            return 0
        else:
            return self.root.size
    def __repr__(self):
        return self.root.node
    def __str__(self):
        return self.__repr__()

    def empty(self):
        '''return true if bst is empty'''
        return not self.root

    def insert(self,val):
        newnode=Node(val)
        if self.empty():
            self.root = newnode
        else:
            self.root.link(newnode)
def test():
    x=Bst()
    x.insert(3)
    x.insert(4)
    x.insert(10)
test()
