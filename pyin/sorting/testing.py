from shell import *
from quick import *
import sys
from random import randint
class Testing:
    def __init__(self,tests=10,leng=30,comp=lambda a,b:a<b,reverse = False,cals=None):
        self.tests=tests
        self.leng=leng
        self.reverse = reverse
        self.comp=comp
        self.cals=cals
        self.comp = comp 
        self.reverse = reverse
        self.auto()
        
    
    def create(self):
        #print('creating...')
        self.li = [randint(-self.leng,self.leng) for _ in range(randint(0,self.leng))]
       # self.x=self.li[:]
        #self.li.sort()
       #print(self.li)
        self.cals(itera=self.li,cmp=self.comp,reverse = self.reverse)
        #print(self.li)
        #print('created')
    def compare(self):
        #print('comparing...')
        it = 0
        while it < len(self.li)-2:
            if not self.comp(self.li[it],self.li[it+1]) and self.li[it]!=self.li[it+1]:
                return False
            it+=1
        return True
        #print('compared')
    
    def auto(self):
        #print('auto..')
        for test in range(self.tests):
            self.create()
            ret = self.compare()
            passed = None
            lii = []
            if ret==True:
                passed ='passed'
            else:
                lii.append(ret)
                passed='failed'
            print(f'Test {test} on lenght {len(self.li)} : {passed}')
        for i in lii:
            print(i)
if __name__ == '__main__':
    tests,maxlen = int(sys.argv[1]),int(sys.argv[2]) 
    rev = True if sys.argv[3]==1 else False
    print('starting...')
    classes = [Shellsort,Quicksort]
    for clas in classes :
        print(clas.__module__)
        Testing(tests,maxlen,reverse = rev,cals=clas)
     
