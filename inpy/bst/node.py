class Node:
    def __init__(self,val=None,parent = None):
        print(val)
        self.value  = val
        self.parent = parent
        self.right  = None
        self.left   = None
        self.size   = 1
    def __eq__(self,other):
        return self.value==other.value
    def __ne__(self,other):
        return not self.__eq__(other)
    def __lt__(self,other):
        return self.value < other.value
    def __le__(self,other):
        return self.value <= other.value
    def __gt__(self,other):
        return self.value > other.value
    def __repr__(self):
        return '<{} {} {}>'.format(self.left, self.value, self.right)
    def __str__(self):
        return self.__repr__()

    def isroot(self):
        if self.parent:
            return False
        return True

    def isleef(self):
        if self.right or self.left:
            return False
        return True

    def link(self,other):
        if other <= self:
            if self.left:
                 Node.link(self.left,other)
            else:
                self.left = other
                other.parent = self
        else:
            if self.right:
                Node.link(self.right,other)
            else:
                self.right = other
                other.parent = self
        self.updateSize()

    def updateSize(self):
        self.size = 1
        if self.right:
            self.size+=self.right.size
        if self.left:
            self.size+=self.left.size


def test():
    x=Node(5)
    y=Node(6)
    a=Node(7)
    x.link(y)
    x.link(a)
    print(x)
    print(x.size)
    print(a.size)
    print(y.size)
    # x.right = y
    # y.left  = a
    # print(x.isroot())
    # print(y.isleef())
    # print(a.isleef())
    # print(x<y)
    # print(x!=a)
    # print(x>a)
test()
