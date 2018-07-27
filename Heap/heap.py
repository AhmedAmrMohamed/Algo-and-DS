class Heap:
    def __init__(self):
        self.li = [None]
        self.max=max
        self.size = 0
        self.parent = lambda a:a//2
        self.left   = lambda a:a<<1
        self.right  = lambda a:(a<<1)|1
        # self.comp   = key
    def __str__(self):
        return str(self.li)

    def __repr__(self):
        return self.__str__()

    def __len__(self):
        return self.size
    def swim(self,pos):
        li=self.li
        while(pos > 1 and li[pos]>li[self.parent(pos)]):
            parent_pos=self.parent(pos)
            li[pos],li[parent_pos] = li[parent_pos],li[pos]
            pos=parent_pos
    def sink(self,pos):
        li=self.li
        left=self.left
        right=self.right
        while right(pos)<=self.size:
                cpos=left(pos)
                if li[cpos]<li[cpos+1]:
                    cpos+=1
                if li[pos]>li[cpos]:
                    break
                li[pos],li[cpos]=li[cpos],li[pos]
                pos=cpos

    def insert(self,item):
        self.li.append(item)
        self.size+=1
        self.swim(self.size)

    def pop(self):
        ret = self.li[1]
        self.li[1]=self.li[self.size]
        self.sink(1)
        self.size-=1
        self.li.pop()
        return ret

    def getmax(self):
        if self.empty():
            return None
        return self.li[1]






import random as ran
class Testing:
    def __init__(self,tests = 10,max_lenght = 30,onlypositive=False):
        self.tests=tests
        self.max_lenght=max_lenght
        self.sign = 1 if not onlypositive else -1
        self.testing()
    def fill(self,n):
        li=[ran.randint(-n,n)*self.sign for i in range(n)]
        x=Heap()
        for i in li:
            x.insert(i)
        return x,li

    def pop(self,x,li):
        li.sort(reverse=True)
        for i in li:
            if i!=x.pop():
                return False
        return True

    def testing(self):
        for test in range(self.tests):
            leng = ran.randint(1,self.max_lenght)
            x,l=self.fill(leng)
            passed='passed' if self.pop(x,l) else 'failed'
            print('test :{} {} on len = {}'.format(test,passed,leng))
            if passed =='failed':
                print(l)    
