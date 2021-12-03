/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Betao
 *
 * Created on 13 de Agosto de 2018, 17:02
 */
//bibliotecas
#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char *argv[]) {
    //declaracao de variaveis
    int num;
    printf("Digite um numero:");
    scanf("%d",&num);//& usado para nao dar erro
    printf("O numero tem como valor %d",num); //%d print numeros inteiros
    return (0);
}

