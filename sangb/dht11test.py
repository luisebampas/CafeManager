import RPi.GPIO as GPIO # 라즈베리파이 GPIO 핀을 쓰기위해 임포트
import paho.mqtt.client as mqtt
import  time
import Adafruit_DHT as dht11

servopin = 23
sensor = dht11.DHT11
pin = 17

GPIO.setmode(GPIO.BCM)
GPIO.setup(servopin, GPIO.OUT)

pwm = GPIO.PWM(servopin, 50)
pwm.start(0)
time.sleep(2)

while True:
    hum, temp = dht11.read_retry(dht11.DHT11, pin)
    if hum is not None and temp is not None:
        print("hum : " + str(hum) + ", temp : " + str(temp))
        if temp == 20:
            pwm.ChangeDutyCycle(3)
            time.sleep(1)
        elif temp == 22:
            pwm.ChangeDutyCycle(6)
            time.sleep(1)
        elif temp == 24:
            pwm.ChangeDutyCycle(9)
            time.sleep(1)
        else:
            pwm.ChangeDutyCycle(12)
            time.sleep(1)
    else:
        print("error")

    time.sleep(1)

pwm.stop()
GPIO.cleanup(servopin)