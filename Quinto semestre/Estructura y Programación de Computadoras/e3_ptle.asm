title "Operaciones"
.model small
.386
.stack 64
.data
    X dw -130d
    Y dw 100d
    res1 dw 0
    res2 dw 0
    res3 dw 0
.code
Inicio:
    mov ax, @data
    mov ds, ax

    mov ax, X; AL = X
    mov dx, Y; DL = Y
    add ax, dx; AL = X + Y
    sub ax, 335d; AX = X + Y - 335d
    add ax, 53d; AX = X + Y - 335d + 53d
    mov res1, ax; res1 = AX
    inc ax; AX = AX + 1
    mov res2, ax; res2 = AX
    mov ax, res1; AX = AX - 1
    dec ax; AX = AX - 1
    mov res3, ax; res3 = AX

Salir:
    mov ax, 4C00h
    Int 21h
    end Inicio
