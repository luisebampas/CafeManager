import RPi.GPIO as GPIO # 라즈베리파이 GPIO 핀을 쓰기위해 임포트
import time # 시간 간격으로 제어하기 위해 임포트
import paho.mqtt.client as mqtt

servopin = 23
GPIO.setmode(GPIO.BCM)  # 핀의 번호를 보드 기준으로 설정, BCM은 GPIO 번호로 호출함
GPIO.setup(servopin, GPIO.OUT)  # GPIO 통신할 핀 설정
flag = 0

class MyMqtt_Sub():
    def __init__(self):

        client = mqtt.Client()
        client.on_connect = self.on_connect
        client.on_message = self.servoMotor
        client.connect("192.168.0.212", 1883, 60)
        client.loop_forever()

    def on_connect(self, client, userdata, flags, rc):
        print("connect.." + str(rc))
        if rc == 0:
            client.subscribe("mycafe/servo")
        else:
            print("연결실패")


    def servoMotor(self,client,degree,msg):
        pwm = GPIO.PWM(servopin, 50)  # 서보모터는 PWM을 이용해야됨. 23번핀을 50Hz 주기로 설정
        pwm.start(6)  # 초기 시작값, 반드시 입력해야됨 2~12
        # time.sleep(2)  # 초기 시작값으로 이동하고 싶지 않으면 이 라인을 삭제하면 된다.

        myval = msg.payload.decode("utf-8")
        print(msg.topic + "----" + str(myval))

        newmyval = (float(myval) /10)+2
        pwm.ChangeDutyCycle(newmyval)
        time.sleep(1)

        # 아래 두줄로 깨끗하게 정리해줘야 다음번 실행할때 런타임 에러가 안남
        pwm.stop()


if __name__ == "__main__":
    try:
        mymqtt = MyMqtt_Sub()

    except KeyboardInterrupt:
        print("종료")
        GPIO.cleanup(servopin)
