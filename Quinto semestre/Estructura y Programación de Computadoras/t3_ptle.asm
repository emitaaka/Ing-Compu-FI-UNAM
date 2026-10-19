title "Sumas y restas grandes"
    .model small
    .386
    .stack 64

    .data
num1 dw 6790h, 0BF93h, 0C642h, 078Ah, 1D53h, 40B7h, 0E50Ah, 75B9h
num2 dw 0F58Dh, 75B3h, 07E3h, 5F31h, 70D7h, 85E2h, 076Ch, 0BC40h
suma dw 0h, 0h, 0h, 0h, 0h, 0h, 0h, 0h, 0h
resta dw 0h, 0h, 0h, 0h, 0h, 0h, 0h, 0h, 0h

    .code
Inicio:
    mov ax, @data
    mov ds, ax; segmento de datos

    clc
    mov cx, 8; preparamos registro cx para loop
    mov bx, 0; preparamos bx para usarlo como índice

ItSuma:
    mov ax, num1[bx]
    mov dx, num2[bx]
    adc ax, dx; suma con acarreo
    mov suma[bx], ax; guardamos el nuevo valor
    inc bx
    inc bx; incrementamos bx dos veces porque son datos tipo word
    loop ItSuma

    adc suma[bx], 0; acarreo final

    clc
    mov cx, 8; volvemos a preparar cx
    mov bx, 0; reiniciamos el índice

ItResta:
    mov ax, num1[bx]
    mov dx, num2[bx]
    sbb ax, dx; resta con borrow
    mov resta[bx], ax; guardamos el nuevo valor
    inc bx
    inc bx
    loop ItResta

    sbb resta[bx], 0; borrow final


Exit:

    mov ax, 4C00h
    int 21h
    end Inicio