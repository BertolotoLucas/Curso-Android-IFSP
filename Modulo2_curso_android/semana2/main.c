/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Betao
 *
 * Created on 13 de Agosto de 2018, 18:53
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char *argv[]) {
    float num1,num2,soma,sub,mult,div;//numero real
    
    printf("Digite um numero: ");
    scanf("%f",&num1);//%f variavel real
    printf("Digite um numero: ");
    scanf("%f",&num2);//%f variavel real
    soma = num1+num2;
    sub = num1-num2;
    mult = num1*num2;
    if(num2!=0){
        div=num1/num2;
    } else {
        div = 0;
    }
    printf("A soma dos numero e: %f",soma); 
    printf("\n");
    printf("A subtracao dos numero e: %f",sub);
    printf("\n");
    printf("A multiplicacao dos numero e: %f",mult); 
    printf("\n");
    if(div > 0){
       printf("A divisao dos numero e: %f",div);
    } else {
        printf("A divisao e invalida");
    }
    printf("\n");
    return (0);
}

