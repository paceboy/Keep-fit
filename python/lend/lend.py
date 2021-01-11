import time

from gate import Gate


class Lend:
    gate = Gate()

    def run(self):
        self.gate.getlendrecord()
        # while(1):

        print "Start : %s" % time.ctime()
        time.sleep(10)
        print "End : %s" % time.ctime()