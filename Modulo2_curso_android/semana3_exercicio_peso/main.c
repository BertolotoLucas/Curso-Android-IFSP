/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Betao
 *
 * Created on 21 de Agosto de 2018, 23:06
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    float peso;
    float altura;
    float imc;
    
    printf("Ola, iremos calcular seu IMC, por favor coloque seu peso: ");
    scanf("%f",&peso);
    while(peso<=0){
        printf("\nError, seu peso esta como menor ou igual a zero!\n");
        printf("Por favor coloque seu peso de verdade: ");
        scanf("%f",&peso);
    }

    printf("Por favor coloque tambem a sua altura: ");
    scanf("%f",&altura);
    
    while(altura<=0){
        printf("\nError, sua altura esta como menor ou igual a zero!\n");
        printf("Por favor coloque sua altura de verdade: ");
        scanf("%f",&altura);
    }
    
    printf("\nObrigado, faremos os calculos, aguarde por favor...\n");
    
    imc = peso/(altura*altura);
    
    if(imc<17){
        printf("\nVoce esta muito abaixo do peso ideal\n");
    } else if (imc>=17 && imc<18.50){
        printf("\nAbaixo do peso\n");    
    } else if(imc>=18.50 && imc<25){
        printf("\nParabens, voce esta no peso ideal\n");
    } else if(imc>=25 && imc<30){
        printf("\nVoce esta acima de seu peso (sobrepeso)\n");
    } else if(imc>=30 && imc<35){
        printf("\nVoce esta na obesidade grau I\n");
    } else if(imc>=35 && imc<40){
        printf("\nVoce esta na obesidade grau II\n");
    } else if(imc>=40){
        printf("\nVoce esta na obesidade grau III\n");
    }
    
    return 0;
}

