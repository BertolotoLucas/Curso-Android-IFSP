/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Betao
 *
 * Created on 31 de Agosto de 2018, 15:56
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int numTabuada = 0;
    printf("Por favor coloque um numero inteiro para fazer a tabuada dele..\n");
    scanf("%d",&numTabuada);
    
    while(!(isdigit(numTabuada))){
        printf("Por favor coloque um numero inteiro para fazer a tabuada dele..\n");
        scanf("%d",&numTabuada);
    }

    for(int aux=0;aux<=10;aux++){
        int mult = aux*numTabuada;
        printf("%d x %d = %d \n", numTabuada,aux,mult);
    }
    
    return (0); 
}

