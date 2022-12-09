using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class GameOverScript : MonoBehaviour
{
    private GUISkin newSkin;
    public string cena;
    // Start is called before the first frame update
    void Start()
    {
        newSkin = Resources.Load("Menu") as GUISkin; 
    }

    void OnGUI()
    {
        const int buttonWidth = 120;
        const int buttonHeight = 60;

        GUI.skin = newSkin;

        //Reiniciando a fase
        if (GUI.Button (
            new Rect (Screen.width / 2 - (buttonWidth / 2),
                    (2 * Screen.height / 4f) - (buttonWidth / 2),
                    buttonWidth, buttonHeight),
            "Retry"))
        {
            SceneManager.LoadScene(cena);
        }

        //Voltar para o menu
        if (GUI.Button(
            new Rect(Screen.width / 2 - (buttonWidth / 2),
                    (2 * Screen.height / 2.5f) - (buttonWidth / 2),
                    buttonWidth, buttonHeight),
            "Menu"))
        {
            SceneManager.LoadScene("Menu");
        }

    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
