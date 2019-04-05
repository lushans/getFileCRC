from zlib import crc32
import sys

def getCRC(file):
    with open(file,'rb') as f:
        return crc32(f.read())& 0xffffffff

if __name__ == '__main__':
    if len(sys.argv) < 2:
        print('You must enter the file')
        exit(1)
    elif len(sys.argv) > 2:
        print('Only one file is permitted')
        exit(1)
    file = sys.argv[1]

    Crc = getCRC(file)
    Dec = int(str(Crc),16)
    print('{:8}{:x}'.format('Hex:',Crc))
    print('{:8}{:x}'.format('Dec:',Dec))

