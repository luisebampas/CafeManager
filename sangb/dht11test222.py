import RPi.GPIO as GPIO # 라즈베리파이 GPIO 핀을 쓰기위해 임포트
import time
import Adafruit_DHT as dht11
from flask import Flask, render_template, request, Response, jsonify

app = Flask(__name__)

servopin = 24
sensor = dht11.DHT11
pin = 17

GPIO.setMode(GPIO.BCM)
GPIO.setup(servopin, GPIO.out)

pwm = GPIO.PWM(servopin, 50)
pwm.start(0)
time.sleep(2)

hum, temp = dht11.read_retry(dht11.DHT11, pin)


@app.route("/update")
def update():
    msg = {
        "hum": hum,
        "temp": temp
    }
    return jsonify(msg)

@app.route("/<command>")
def action(command):
    if command == "on":
        while True:
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
    else:
        message = "fail"

    msg = {
        "message": message,
        "hum": hum,
        "temp": temp
    }
    return render_template("test.html", **msg)

if __name__ == "__main__":
    try:
        app.run(host="0.0.0.0", debug=True)
    except KeyboardInterrupt:
        print("종료")

pwm.stop()
GPIO.cleanup(servopin)