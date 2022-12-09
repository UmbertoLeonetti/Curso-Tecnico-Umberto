using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

using UnityEngine.SceneManagement;

public class SaudeInimigo : MonoBehaviour
{

    public bool morto;
    //public int saude;
    private Animator animator;
    public int _life = 10;



    // Use this for initialization
    void Start()
    {
        morto = false;
        animator = gameObject.GetComponent<Animator>();
    }
    public void TakeDamage(int damage)
    {
        _life -= damage;
        if (_life <= 0)
        {
            if (morto.Equals(false))
            {
                animator.SetBool("Morte", true);
            }
            morto = true;
            Invoke("Morte", 0.8f);


        }

    }

    void Dead()
    {
        Destroy(this.gameObject);
    }

}