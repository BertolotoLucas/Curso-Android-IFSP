/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Betao
 *
 * Created on 21 de Agosto de 2018, 22:39
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int x;
    int z;
    
    printf("Digite um numero inteiro: ");
    scanf("%d",&x);
    
    printf("Digite outro numero inteiro: ");
    scanf("%d",&z);
    
    if(x<z){
        printf("X e menor que Z");
        printf("\nAgora irei mostra los em ordem crescente : \n");
        printf("%d %d",x,z);
    }
    else if(x==z){
        printf("X e igual a Z");
        printf("\nNao e possivel mostra los em ordem crescente \n");

    }
    else{
        printf("X e maior que Z");
        printf("\nAgora irei mostra los em ordem crescente : \n");
        printf("%d %d",z,x);
    }
    
    return 0;
}

