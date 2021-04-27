import RPi.GPIO as GPIO  # 라즈베리파이 GPIO 핀을 쓰기위해 임포트
import time
import Adafruit_DHT as dht11

sensor = dht11.DHT11
pin = 17
en = 16
in1 = 21
in2 = 20

GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)
GPIO.setup(en, GPIO.OUT)
GPIO.setup(in1, GPIO.OUT)
GPIO.setup(in2, GPIO.OUT)

p = GPIO.PWM(en, 1000)

p.start(0)

while True:
    hum, temp = dht11.read_retry(dht11.DHT11, pin)
    if hum is not None and temp is not None:
        print("hum : " + str(hum) + ", temp : " + str(temp))
        if temp <= 20:
            p.ChangeDutyCycle(30)
            time.sleep(5)
        elif 20 < temp <= 23:
            p.ChangeDutyCycle(55)
            time.sleep(5)
        elif 23 < temp <= 26:
            p.ChangeDutyCycle(75)
            time.sleep(5)
        elif temp > 26:
            p.ChangeDutyCycle(100)
            time.sleep(5)
    else:
        print("error")

GPIO.cleanup()
p.stop()
