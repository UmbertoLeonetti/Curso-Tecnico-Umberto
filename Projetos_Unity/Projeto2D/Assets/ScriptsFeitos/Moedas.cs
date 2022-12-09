using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Moedas : MonoBehaviour
{
    // Start is called before the first frame update
    private Collider2D colider;
    private Animator _animator;
    private Vector3 healthBarScale;
    private float healthPercent;

    public int vida = 1;
    public Transform healthBar;
    public GameObject healthBarObject;
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }
    void OnTriggerStay2D(Collider2D outro)
    {
        colider = outro;
        if (outro.gameObject.tag == "Player")
        {
            //if (outro.gameObject.GetComponent<Saúde>().full_life.Equals(false))
            {
                //_animator.SetBool("Coletar", true);
                healthBarScale = healthBar.localScale;
                healthPercent = healthBarScale.x;
                UpdateHealthBar();
                //outro.gameObject.GetComponent<Saúde>().buff(vida);
                //Destroy(this.gameObject);
            }
        }
    }
    void UpdateHealthBar()
    {
        healthBarScale.x = healthPercent + 0.67f;
        healthBar.localScale = healthBarScale;
    }


}
