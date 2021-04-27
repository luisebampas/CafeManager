import RPi.GPIO as GPIO
import  time

servopin = 23

GPIO.setMode(GPIO.BCM)
GPIO.setup(servopin, GPIO.out)

pwm = GPIO.PWM(servopin, 50)
pwm.start(0)
time.sleep(2)

for i in range(1, 13):
    pwm.ChangeDutyCycle(i)
    time.sleep(1)

pwm.stop()
GPIO.cleanup(servopin)