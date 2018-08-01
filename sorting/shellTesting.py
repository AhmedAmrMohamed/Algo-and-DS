from shell import *
from merge import *
from random import randint
class Testing:
    def __init__(self,tests=10,leng=30,comp=lambda a,b:a<b,reverse = False):
        self.tests=tests
        self.leng=leng
        self.reverse = reverse
        self.comp=comp
        self.auto()
    
    def create(self):
        self.li = [randint(-self.leng,self.leng) for _ in range(randint(0,self.leng))]
        self.x=self.li[:]
        self.li.sort()
        Shellsort.sort(itera=self.x,cmp=self.comp,reverse = self.reverse)

    def compare(self):
        for i,ii in zip(self.li,self.x):
            if(i!=ii):
                return (self.li,self.x)
        return True
    
    def auto(self):
        for test in range(self.tests):
            self.create()
            ret = self.compare()
            passed = None
            li = []
            if ret==True:
                passed ='passed'
            else:
                li.append(ret)
                passed='failed'
            print(f'Test {test} on lenght {self.leng} : {passed}')
        for i in li:
            print(i)
if __name__ == '__main__':
    Testing(300,50)
