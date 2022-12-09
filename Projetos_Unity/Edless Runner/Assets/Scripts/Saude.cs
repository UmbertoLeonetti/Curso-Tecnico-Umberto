using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Saude : MonoBehaviour
{
    public bool morto;
    public int saude;
    public Canvas GameOver;

    void Start()
    {
        morto = false;
    }

    void Update()
    {
    }

    public void dano(int x)
    {
        saude -= x;
        if (saude <= 0)
        {
            morto = true;
            StartCoroutine(morre());
        }
    }

    public void danoMax()
    {
        saude = 0;
        morto = true;
        StartCoroutine(morre());
    }

    IEnumerator morre()
    {
        Time.timeScale = 0;
        GameOver.gameObject.SetActive(true);
        yield return new WaitForSeconds(1.0f);
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);

    }

    internal void ApplyDamage(float damageAmount)
    {
        throw new NotImplementedException();
    }
}