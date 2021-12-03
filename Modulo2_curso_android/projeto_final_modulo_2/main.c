//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M2LPBA

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Lucas Bertoloto dos Santos

//******************************************************
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char** argv) {
    // OBJETIVO.......: Inicializando o nosso vetor de tamanho 5
    
    const int tamVetor = 5;
    int v[tamVetor];
    
    // OBJETIVO.......: Loop para armazenar os valores inteiros que o usuario ira digitar, afim de popular o nosso vetor
    // OBJETIVO.......: Para cada loop sera pedido ao usuario que digite um valor inteiro
    
    for(int i=0;i<tamVetor;i++){ 
        printf("\n");
        printf("Por favor insira um valor inteiro para a posicao %d do vetor : ",i+1); //Repare que sera melhor para o usuario dizer que a primeira posicao comeca pelo 1
        scanf("%d",&v[i]);
    };
    
    // OBJETIVO.......: Inicializar a nossa variavel soma e mult
    // OBJETIVO.......: Repare que mult deve ser inicializada valendo como 1 e NAO como 0, pois caso comece valendo 0 a multiplicacao sempre sera igual a 0
    
    int soma = 0;
    int mult = 1;
    
    // OBJETIVO.......: Em apenas um loop, vamos somar todos os valores do array e armazenaremos o resultado na variavel soma
    // OBJETIVO.......: Tambem iremos multiplicar todos os valores do array e armazenaremos o resultado na variavel mult
    
    for(int i=0;i<tamVetor;i++){
        soma = soma + v[i];
        mult = mult * v[i];
    };
    
    
    // OBJETIVO.......: Apresentar para o usuario os valores de nossas duas variaveis e para cada variavel tambem iremos dizer se seu valor e positivo, nulo ou negativo
    // OBJETIVO.......: Apresentando o valor da soma
    
    printf("\n");
    printf("Valor da soma e igual a : %d",soma);
    
    // OBJETIVO.......: Apresentando se o valor da soma e negativo, nulo ou negativo
    
    if(soma<0){
        printf("\n");
        printf("Valor da soma eh negativo..");
    }
     else if(soma>0){
         printf("\n");
         printf("Valor da soma eh positivo.."); 
     }
     else{
         printf("\n");
         printf("Valor da soma eh nulo..");
     }
    
    // OBJETIVO.......: Apresentando o valor da multiplicacao
    
    printf("\n\n");
    printf("Valor da multiplicacao : %d",mult);
    
    // OBJETIVO.......: Apresentando se o valor da multiplicacao e negativo, nulo ou negativo
    
    if(mult<0){
        printf("\n");
        printf("Valor da multiplicacao eh negativo..");
    }
     else if(soma>0){
         printf("\n");
         printf("Valor da multiplicacao eh positivo.."); 
     }
     else{
         printf("\n");
         printf("Valor da multiplicacao eh nulo..");
     }   
    
    return (0);
}

