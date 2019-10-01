import logging
class Quicksort:
    def __init__(self,itera,cmp = lambda a,b:a<b,reverse=False):
        self.li=itera
        self.key = cmp
        if reverse:
            self.key = lambda cmp:not cmp
        self.quicksort(0,len(self.li)-1)

    def quicksort(self,start,end):
        if start>=end:
            return
        pivot = self.partition(start,end) 
        self.quicksort(pivot+1,end)
        self.quicksort(start,pivot-1)

    def partition(self,start,end):
        pivot,lo,hi = start,start,end
        li=self.li
        while lo<hi:
            while self.key(li[lo],li[pivot]) and lo <end:
                lo+=1
            while not self.key(li[hi],li[pivot]) and hi>start:
                hi-=1
            if lo<hi:    
                li[lo],li[hi]=li[hi],li[lo]
        li[hi],li[pivot]=li[pivot],li[hi]
        return hi
