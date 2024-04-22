#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>


/* File whosort.c */
void main(void)
{
    int fds[2]; // array de dos enteros de dos posiciones para el pipe
    pid_t pid;
    pipe(fds); /*Crea un pipe */
    /* El primer hijo reconecta su entrada estándar (stdin) al flujo
       de salida del pipe y cierra el descriptor de la entrada del pipe
    */
    if ((pid = fork()) < 0)
    {
        perror("Fallo del fork al crear el primer hijo");
        exit(1);
    }
    else if (pid == 0)
    { // retorno del fork en el primer hijo

        dup2(fds[0], 0);
        close(fds[1]);
        execlp("sort", "sort", NULL); // recubrimiento
    }
    /* El segundo hijo reconecta su salida estándar (stdout) a la
       entrada del pipe y cierra el descriptor de la salida del pipe
    */
    else
    { // retorno del fork en el padre
        if ((pid = fork()) < 0)
        {
            perror("Fallo el segundo fork");
            exit(2);
        }
        else if (pid == 0)
        { // retorno del fork en el segundo hijo
            dup2(fds[1], 1);
            close(fds[0]);
            execlp("who", "who", NULL); // recubrimiento
        }
        else
        { // retorno segundo fork en el apodre
            close(fds[0]);
            close(fds[1]);
            wait(0);
            wait(0);
        }
    }
}
