from flask import Flask, render_template, request, Response, redirect, url_for

def create_app():
    app = Flask(__name__);

    @app.route('/home')
    def home_display():
        return render_template('home.html')

    @app.route('/menu')
    def menu_display():
        return render_template('menu.html')

    @app.route('/storage')
    def storage_display():
        return render_template('storage.html')

    @app.route('/video')
    def video_display():
        return render_template('video.html')

    return app;

if __name__ == '__main__':
    try:
        create_app().run(host='0.0.0.0', port=5000, debug=True)
    except KeyboardInterrupt:
        print("Exit...")