using UnityEngine;
using System.Collections;
using UnityEngine.UI;


public class GameManager : MonoBehaviour
{

    public static GameManager gm;
    public Saúde _life;

    [Tooltip("If not set, the player will default to the gameObject tagged as Player.")]
    public GameObject player;

    public enum gameStates { Playing, Death, GameOver, BeatLevel };
    public gameStates gameState = gameStates.Playing;

    public int score = 0;
    public bool canBeatLevel = false;
    public int beatLevelScore = 0;
    public GameObject telaGanhou;

    public GameObject boss;
    public GameObject mainCanvas;
    public Text mainScoreDisplay;
    public GameObject gameOverCanvas;
    public Text gameOverScoreDisplay;

    [Tooltip("Only need to set if canBeatLevel is set to true.")]
    public GameObject beatLevelCanvas;

    public AudioSource backgroundMusic;
    public AudioClip gameOverSFX;

    [Tooltip("Only need to set if canBeatLevel is set to true.")]
    public AudioClip beatLevelSFX;

    private Saúde playerHealth;

    void Start()
    {
        if (gm == null)
            gm = gameObject.GetComponent<GameManager>();

        if (player == null)
        {
            player = GameObject.FindWithTag("Player");
        }

        playerHealth = player.GetComponent<Saúde>();


        // make other UI inactive
        gameOverCanvas.SetActive(false);
        if (canBeatLevel)
            beatLevelCanvas.SetActive(false);
    }

    void Update()
    {
    }
}
