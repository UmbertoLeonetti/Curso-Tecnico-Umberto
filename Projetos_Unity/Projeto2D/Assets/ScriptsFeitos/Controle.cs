using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Controle : MonoBehaviour {
    public int velocidade = 10;
    public int forcadoPulo = 500;
    public Transform terra;
    public LayerMask chao;

    private float moveX;
    private bool direita = true;
    private bool noChao;
    private Animator animator;
    public Transform attackCheck;
    public float radiusAttack;
    public LayerMask layerEnemy;
    float timeNextAttack;
    Rigidbody2D body;
    // Start is called before the first frame update
    void Start()
    {
        body = GetComponent<Rigidbody2D>();
        animator = gameObject.GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update() {
        moveJogador();

        if (Input.GetButtonDown("Fire1"))
        {
            animator.SetTrigger("Ataque");
        }

        if (timeNextAttack <= 0)
        {
            if (Input.GetButtonDown("Fire1") && body.velocity == new Vector2 (0, 0))
            {
                animator.SetTrigger("Ataque");
                timeNextAttack = 0.2f;
            }
        } else
        {
            timeNextAttack -= Time.deltaTime;
        }
    }
    private void LateUpdate()
    {
        viraJogador();
    }

    void Flip()
    {
        attackCheck.localPosition = new Vector2(-attackCheck.localPosition.x, attackCheck.localPosition.y);
    }

    void moveJogador() {
        // CONTROLES
        moveX = Input.GetAxis("Horizontal");
        noChao = Physics2D.Linecast(transform.position, terra.position, chao);
        gameObject.GetComponent<Rigidbody2D>().velocity = new Vector2(moveX * velocidade,
                                                                       gameObject.GetComponent<Rigidbody2D>().velocity.y);


        if (Input.GetButtonDown("Jump") && noChao) {
            pula();
        }
        //Fisica

        Physics2D.IgnoreLayerCollision(this.gameObject.layer, LayerMask.NameToLayer("chao"), (gameObject.GetComponent<Rigidbody2D>().velocity.y > 0.0f));

        //Animação
        animator.SetBool("NoChao", noChao);
        if (moveX != 0)
        {
            animator.SetBool("Correndo", true);
        }
        else
        {
            animator.SetBool("Correndo", false);
        }
    }
    void pula() {
        GetComponent<Rigidbody2D>().AddForce(Vector2.up * forcadoPulo);
    }
    void viraJogador()
    {
        if (moveX > 0)
        {
            direita = true;
        }
        else if (moveX < 0)
        {
            direita = false;
        }
        Vector2 escala = transform.localScale;

        if ((escala.x > 0 && !direita) || (escala.x < 0) && direita)
        {
            escala.x = escala.x * -1;
            transform.localScale = escala;
        }
    }
    //plataforma
    private void OnCollisionEnter2D(Collision2D outro)
    {
        if (outro.gameObject.tag == "PlataformaMovel")
        {
            this.transform.parent = outro.transform;
        }
    }
    private void OnCollisionExit2D(Collision2D outro)
    {
        if (outro.gameObject.tag == "PlataformaMovel")
        {
            this.transform.parent = null;
        }
    }

    void PlayerAttack()
    {
        Collider2D[] enemiesAttack = Physics2D.OverlapCircleAll(attackCheck.position, radiusAttack, layerEnemy);
        for (int i = 0; i < enemiesAttack.Length; i++)
        {
            enemiesAttack[i].SendMessage("EnemyHit");
            Debug.Log(enemiesAttack[i].name);
        }
    }

    void OnDrawGizmosSelected()
    {
        Gizmos.color = Color.red;
        Gizmos.DrawWireSphere(attackCheck.position, radiusAttack);
    }

    //void morre()
    //{
    //    transform.parent.gameObject.AddComponent<GameOverScript>();   
    //}

   // private void OnCollisionEnter2D(Collision collision)
   // {
    //    SceneManager.LoadScene("GameOver");   
   // }
}
