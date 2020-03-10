# python3.5+
import sys
from time import time

def test(func,data):
    ''' used to test the four methods from the command line '''
    func = int(func)
    if func < 3:
        N = int(data[0])
    if func == 0 :
        print(fibrec(N))
    elif func == 1:
        print(fibtob(N))
    elif func == 2:
        print(fibbot(N))
    elif func == 3:
        print(BNC(N))
    elif func == 4:
        data = list(map(int,data))
        res = BNL(data)
        for a,b in zip(data,res):
            print(a,',',','.join(map(str,b)))
    elif func==5:
        restob = BNR(fibtob,data)
        resbot = BNR(fibbot,data)
        for a,b,c in zip(data,restob,resbot):
            print(','.join(map(str,(a,b,c))))
    
def fibrec(n):
    ''' Fibonaci Simple Reccurrsive Approch '''
    if n<2 :
        return 1
    return fibrec(n-1) + fibrec(n-2)

def fibtob(n):
    ''' Fibonaci Top to Bottom Approch '''
    dic = {}    # used for memoization 
    def calc(n):
        if n < 2:                       # base case
            return 1    
        if dic.get(n,None) != None:     # value calulated before
            return dic[n]
        dic[n] = calc(n-1) + calc(n-2)
        return dic[n]
    return calc(n)

def fibbot(n):
    ''' Fibonaci Top to Bottom Approch '''
    last,before = 1,1
    i = 2
    while i <= n:
        before += last
        last,before = before,last
        i+=1
    return last

def BNC(n):
    ''' 
    BenchMark the three approches over one cas : n
    won't run the recurrsive approch on cases where n >= 4
    '''
    t0 = time()
    if n <= 40:
        fibrec(n)
    t1 = time()
    fibtob(n)
    t2 = time()
    fibbot(n)
    t3 = time()
    return t1-t0,t2-t1,t3-t2

def BNL(l):
    '''
    BenchMark the three approches over a list of casses : l
    Pleas Note : the results are in seconds and the there is e-0x 
    at the end of most results.
    '''
    res = []
    for i in l:
        res.append(BNC(i))
    return res

def BNR(func,inp,times = 10000):
    ''' 
    BenchMark the function `func` on values `inp` 
    for `times` time and return the average run time
    for each value in a list
    '''
    res = [] 
    for el in map(int,inp):
        su = 0
        for i in range(times):
            t0 = time()
            func(el)
            t1 = time()
            su += t1-t0
        res.append((su/times))
    return res


def main():
    if len(sys.argv) >=3:
        argv = list(sys.argv)
        func    = argv[1]
        data    = argv[2:]
        test(func,data)
main()


