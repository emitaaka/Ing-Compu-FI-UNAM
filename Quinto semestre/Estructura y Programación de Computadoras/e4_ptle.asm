title "Ecuacion"
.model small
.386
.stack 64
.data
    z dw 0
    x dw 60
    y dw 162
.code
Inicio:
    mov ax, @data
    mov ds, ax

    ;6x^2
    mov ax, x; AX = x
    mul x; AX = x * x
    mov bx, 6d; BX = 6d
    mul bx; AX = 6 * x * x
    mov z, ax; Guardamos en z lo que llevamos
    
    ;12*y/5
    mov ax, y; AX = y
    mov bx, 12d; BX = 12d
    mul bx; AX = 12 * y
    mov bx, 5; BX = 5
    div bx; AX = 12 * y / 5

    sub z, ax; z= z - AX

    ;x*y
    mov ax, x; AX = x
    mov bx, y; AX = y
    mul bx; AX = x * y

    sub z, ax; z = z - AX

    ;15x
    mov ax, x; AX = x
    mov bx, 15; BX = 15
    mul bx; AX = 15x

    add z, ax; z = z + AX
    
    sub z, 3000d; z = z - 3000

Salir:
    mov ax, 4C00H
    int 21h

    end Inicio