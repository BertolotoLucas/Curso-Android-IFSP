/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Betao
 *
 * Created on 31 de Agosto de 2018, 16:16
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int contador=0;

    for(int i = 150; i<=200; i=i+2){
        contador++;
    }
    
    printf("Existem %d numeros pares no intervalo de 150 ate 200..\n",contador);
    
    int somatorio =0;
    
    for(int i=1; i<=200;i++){
        somatorio=somatorio+i;
    }
    
    printf("A soma de todos os numeros no intervale de 1 ate 200 vale: %d\n",somatorio);
    
    //media das notas de um aluno:
    
    float nota=0;
    int static qntNotas = 10;
    somatorio=0;
    
    for(int i = 1; i<=qntNotas;i++){
        printf("Coloque a nota %d do aluno : ",i);
        scanf("%f",&nota);
        somatorio = somatorio+nota;
    }
    
    float media = somatorio/qntNotas;
    
    printf("A media do aluno e: %f",media);
    
    return (0);
}

