import openai
import speech_recognition as sr
import pyttsx3
import requests
import webbrowser

openai.api_key = 'api key'

# Initialize the TTS engine
engine = pyttsx3.init('sapi5')
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[0].id)

def speak(text):
    engine.say(text)
    engine.runAndWait()

def take_command():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        r.pause_threshold = 1
        r.adjust_for_ambient_noise(source)
        audio = r.listen(source)

    try:
        print("Recognizing...")
        query = r.recognize_google(audio, language='en-in')
        print(f"You said: {query}\n")
    except Exception as e:
        print("Sorry, I didn't catch that. Please repeat.")
        return "None"
    return query.lower()

def ask_gpt(query):
    response = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[
            {"role": "system", "content": "You are a helpful assistant named JARVIS."},
            {"role": "user", "content": query},
        ]
    )
    return response['choices'][0]['message']['content']

def get_weather(city):
    api_key = "your-openweathermap-api-key"
    base_url = f"http://api.openweathermap.org/data/2.5/weather?q={city}&appid={api_key}&units=metric"
    response = requests.get(base_url)
    data = response.json()
    
    if data["cod"] != "404":
        main = data["main"]
        temperature = main["temp"]
        humidity = main["humidity"]
        weather_desc = data["weather"][0]["description"]
        weather_response = f"The temperature is {temperature}°C, humidity is {humidity}%, and the weather is {weather_desc}."
    else:
        weather_response = "Sorry, I couldn't find the weather information for that location."
    
    return weather_response

def play_music(song):
    speak(f"Playing {song}")
    webbrowser.open(f"https://www.youtube.com/results?search_query={song}")

def execute_command():
    speak("I am JARVIS, your personal assistant. How can I assist you today?")
    while True:
        query = take_command()

        if query == "None":
            continue

        if 'weather' in query:
            speak("Please tell me the city name.")
            city = take_command()
            if city != "None":
                weather_info = get_weather(city)
                speak(weather_info)

        elif 'play music' in query:
            speak("What song do you want to play?")
            song = take_command()
            if song != "None":
                play_music(song)

        elif 'exit' in query or 'quit' in query or 'stop' in query:
            speak("Goodbye! Have a nice day.")
            break

        else:
            # Fallback to GPT-4 for other commands
            response = ask_gpt(query)
            print(f"JARVIS: {response}")
            speak(response)

if __name__ == "__main__":
    execute_command()
