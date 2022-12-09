using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Saúde : MonoBehaviour
{
    public bool morto;
    
    public bool full_life;
    public int _life = 10;
    public int saude;
    private Animator animator;
    public Transform healthBar;
    public GameObject healthBarObject;

    private Vector3 healthBarScale;
    private float healthPercent;

    // Use this for initialization
    void Start()
    {
        morto = false;
        animator = gameObject.GetComponent<Animator>();

        healthBarScale = healthBar.localScale;
        healthPercent = healthBarScale.x / _life;
    }

    private void Update()
    {
        if (_life.Equals(10))
        {
            full_life = true;
        }
        else
        {
            full_life = false;
        }
    }
    void UpdateHealthBar()
    {
        healthBarScale.x = healthBarScale.x - 0.67f;
        healthBar.localScale = healthBarScale;
    }

    public void dano(int x)
    {
        saude -= x;
        if (saude <= 0)
        {
            morto = true;
            animator.SetTrigger("Morte");
            StartCoroutine(morre());
        }
    }

    public void danoMax()
    {
        saude = 0;
        morto = true;
        animator.SetTrigger("Morte");
        if (gameObject.tag == "Player")
        {
            StartCoroutine(morre());
        }
    }

    public void TakeDamage(int damage)
    {
        _life -= damage;
        UpdateHealthBar();

        if (_life <= 0)
        {
            if (morto.Equals(false))
            {
                animator.SetBool("Morte", true);
            }
            morto = true;

            if (transform.tag.Equals("Player"))
            {
                StartCoroutine(morre());
            }


        }

    }

    public void buff(int buff)
    {
        _life = _life + buff;
    }
    //IEnumerator
    IEnumerator morre()
    {
        yield return new WaitForSeconds(1.0f);
        SceneManager.LoadScene("GameOver");
        //transform.parent.gameObject.AddComponent<GameOverScript>();
       // SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }
}