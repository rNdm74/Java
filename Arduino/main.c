/* 
 * File:   main.c
 * Author: rndm
 *
 * Created on 17 May 2013, 10:56 AM
 */

#include <stdio.h>
#include <stdlib.h>
/*
 * 
 */
const char CHAR_BIT = 8;

void masking(int num){ 
        //Initialize mask
        unsigned int mask = 0x80000000;
        
        size_t bits = sizeof(num) * CHAR_BIT;

        int count;
        
        for (count = 0 ;count < bits; count++) {

            //print
            (mask & num ) ? printf("1") : printf("0");

            //shift one to the right
            mask = mask >> 1;
        }
}

int main(int argc, char** argv) {
    
    masking(1);   
    
    return (EXIT_SUCCESS);
}



