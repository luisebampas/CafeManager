import RPi.GPIO as GPIO  # 라즈베리파이 GPIO 핀을 쓰기위해 임포트
import time

en = 16
in1 = 21
in2 = 20

GPIO.setmode(GPIO.BCM)
GPIO.setup(en, GPIO.OUT)
GPIO.setup(in1, GPIO.OUT)
GPIO.setup(in2, GPIO.OUT)

p = GPIO.PWM(en, 1000)

p.start(0)



while True:
    try:
        a = input()
        if a == "r":
            p.ChangeDutyCycle(50)
        elif a == "q":
            p.ChangeDutyCycle(100)
    except KeyboardInterrupt:
        print("error")

GPIO.cleanup()
p.stop()
