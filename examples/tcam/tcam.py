#!/usr/bin/env python

from fast_tlutmap import run

def main():
    run('tcam.vhd', K=4, performCheck=True, verboseFlag=False)

if __name__=="__main__":
    main()
