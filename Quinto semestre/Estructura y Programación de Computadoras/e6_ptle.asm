title "Hola mundo!" 
	.model small 
	.386		
	.stack 64 	
	.data		
hola 	db 0ADh, "Hola mundo!", 0Dh,0Ah,"$"
	.code				
inicio:					
	mov ax,@data 		
	mov ds,ax 			


	mov cx, 20d; CX = 20
	lea dx,[hola]		
	mov ax,0900h	
	
Veinte:
	int 21h
	loop Veinte; CX - 1 & CX != 0 ?

salir:					
	mov ax, 4C00h			
	int 21h				
	end inicio			