class Shellsort:
    def sort(itera,cmp=lambda a,b:a<b,reverse = False):
        key = lambda a,b : cmp(a,b) if not reverse else not cmp(a,b)
        size=len(itera)
        # print(size)
        h=1
        while 3*h+1 < size:
            h = 3*h+1
        while h>0:
            Shellsort.__shellsort(itera,h,size,key)
            h=(h-1)//3

    def __shellsort(itera,h,size,key):
        for pos in range(0,size,h):
            it=pos
            while it-h >= 0 and key(itera[it],itera[it-h]):
                itera[it],itera[it-h]=itera[it-h],itera[it]
                it-=h
            pos+=h
