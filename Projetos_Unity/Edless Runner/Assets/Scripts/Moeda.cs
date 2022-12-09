using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Moeda : MonoBehaviour
{
    public Text scoreTxt;
    private int score;
    void Start()
    {
        score = 0;
    }

    // Update is called once per frame
    void Update()
    {
        scoreTxt.text = score.ToString();
    }
    private void OnTriggerEnter2D(Collider2D col)
    {
        if (col.CompareTag("gemas") == true) {
            score = score + 1;
            Destroy(col.gameObject);
        }
    }
}
