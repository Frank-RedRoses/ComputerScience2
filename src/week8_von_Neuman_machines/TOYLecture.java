package week8_von_Neuman_machines;

import edu.princeton.cs.algs4.In;

public class TOYLecture {

    public static void main(String[] args) {
        int pc = 0x10;          // program counter
        int[] R = new int[16];  // registers
        int[] M = new int[256]; // main memory

        // load the initial data or instructions
        In in = new In(args[0]);
        for (int i = 0x10; i < 0xFF && !in.isEmpty(); i++) {
            M[i] = Integer.parseInt(in.readString(), 16);   // parse base 16 String
        }

        // Turn on, run toy until stopped the simulation (turn off)
        /*  Bitwhacking is the same in Java as in TOY:
         *   - Extract fields for both instruction formats.
         *   - Use shift and mask technique
         *                       1    C    A    B
         *   ir =               0001 1100 1010 1011
         *   ir >> 8 =          0000 0000 0001 1100
         *   0xF =              0000 0000 0000 1111
         *   (ir >> 8) & 0xF =  0000 0000 0000 1100
         *                                      C
        **/
        while (true) {
            int ir = M[pc++];   // fecht instruction and increment pc 

            // decode the instructions
            int op = (ir >> 12) & 0xF;      // opcode   (bits 12-15)
            int d = (ir >> 8) & 0xF;        // dest d   (bits 08-11)
            int s = (ir >> 4) & 0xF;        // source s (bits 04-07)
            int t = (ir >> 0) & 0xF;        // source t (bits 00-03)
            int addr = (ir >> 0) & 0xFF;    // addr     (bits 00-07)

            // Implement the simple state changes for each instruction:
            // execute
            if (op == 0) break;     //halt
            
            switch (op) {
                case 1: R[d] = R[s] + R[t];         break;
                case 2: R[d] = R[s] - R[t];         break;
                case 3: R[d] = R[s] & R[t];         break;
                case 4: R[d] = R[s] ^ R[t];         break;
                case 5: R[d] = R[s] << R[t];        break;
                case 6: R[d] = R[s] >> R[t];        break;
                case 7: R[d] = addr;                break;
                case 8: R[d] = M[addr];             break;
                case 9: M[addr] = R[d];             break;
                case 10: R[d] = M[R[t]];            break;
                case 11: M[R[t]] = R[d];            break;
                case 12: if (R[d] == 0) pc = addr;  break;
                case 13: if (R[d] > 0) pc = addr;   break;
                case 14: pc = R[d];                 break;
                case 15: R[d] = pc; pc = addr;      break;
            }
        }

        /* *********** A few omitted details. *************
         * - R[0] is always 0 (put R[0] = 0 before execute).
         * - StdIn/StdOut (add code to do it if addr is FF).
         * - Need casts and bitwhacking in a few places
         *   because TOY is 16-bit and Java is 32-bit.
         * - Need more flexible input format to allow for
         *   loading programs elsewhere in memory.
         * 
         * See full implementation TOY.java on booksite
         */
    }
}
