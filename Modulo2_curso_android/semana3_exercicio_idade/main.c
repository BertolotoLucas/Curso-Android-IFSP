/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Betao
 *
 * Created on 21 de Agosto de 2018, 23:33
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int idade;
    printf("Para saber seu perfil de eleitor, por favor coloque sua idade, em anos: ");
    scanf("%d",&idade);
    
    while(idade<=0){
        printf("\nError, sua idade nao pode ser menor ou igaul a zero\n");
        printf("\nPor favor coloque sua idade verdadeira, em anos: \n");
        scanf("%d",&idade);
    }
    
    if(idade<16){
        printf("\nNao eleitor.\n");
    } else if(idade>=16 && idade<18 || idade>65){
        printf("\nEleitor facultativo.\n");  
    } else{
        printf("\nEleitor obrigatorio.\n");
    }
    
    return 0;
}

