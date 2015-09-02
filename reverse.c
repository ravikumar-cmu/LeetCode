#include<stdio.h>

int main () {

	char *input = "hello";

	printf("Input = %s", input);
	int i=0;
	while (*input+i != '\0') {
		i++;
	}

	return 0;				
}