def sort(arr,reverse=False,key = lambda a,b:a<b ):
    n=len(arr)
    cmp = lambda key: key
    if reverse:
        cmp = lambda key:not key
    if n==1:
        return arr
    elif n==2:
        if cmp(key(arr[0],arr[1])) :
            return [arr[0],arr[1]]
        return [arr[1],arr[0]]
    l=[]
    fi = arr[0:n//2]
    se = arr[n//2:n]
    fi =sort(fi,reverse,key)
    se =sort(se,reverse,key)
    pfi,pse=0,0
    ret = []
    while pfi<len(fi) and pse<len(se):
        if cmp(key(fi[pfi],se[pse])) :
            ret.append(fi[pfi])
            pfi+=1
        else:
            ret.append(se[pse])
            pse+=1
    ret.extend(fi[pfi:])
    ret.extend(se[pse:])
    return ret
