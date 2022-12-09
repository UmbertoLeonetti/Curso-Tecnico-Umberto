using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DanoArma : MonoBehaviour
{

    public int dano = 5;
    public string tagInimigo = "Inimigo";
    public GameObject explosao;

    private void OnTriggerEnter2D(Collider2D outro)
    {
        if (outro.tag.Equals(tagInimigo))
        {
            if (outro.gameObject.GetComponent<Saúde>().morto.Equals(false))
                outro.gameObject.GetComponent<Saúde>().TakeDamage(dano);

        }

        if (explosao)
        {
            Instantiate(explosao, transform.position, transform.rotation);
        }


    }
}