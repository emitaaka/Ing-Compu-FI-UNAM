title "Operaciones logicas"
.model small
.386
.stack 64
.data 
    A db 01011111b
    B db 10101010b
    C db 11110000b
    X db 0
.code
Inicio:
    mov ax, @data
    mov ds, ax

    mov al, B; AL = B
    mov dl, C; AL = C
    or al , dl; AL = B v C
    mov dl, A; DL = A
    and al, dl; AL = A ^ (B v C)
    mov bl, B; BL = B
    mov dl, C; DL = C
    and bl, dl; BL = B ^ C
    xor al, bl; AL = A ^ (B v C) [+] B ^ C
    mov dl, A; DL = A
    not dl; DL = ¬A
    or al, dl; AL = A ^ (B v C) [+] B ^ C ^ ¬A
    mov X, al; X = AL

Salir:
    mov ax, 4C00H;
    int 21h

    end Inicio