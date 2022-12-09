using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Menu : MonoBehaviour
{
    public string cena;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        //transform.parent.gameObject.AddComponent<GameOverScript>();
    }

    public void StartGame()
    {
        SceneManager.LoadScene(cena);
    }
    public void QuitGame()
    {
        //Editor Unity
        UnityEditor.EditorApplication.isPlaying = false;
        //Compilado
        //Application.Quit();
    }
}
